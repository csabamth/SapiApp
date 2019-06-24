<?php
namespace App\Http\Controllers\API;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;  
use App\User;
use Validator; 
class AuthController extends Controller
{

 public function register(Request $request)
 {
  $validator = Validator::make($request->all(), [ 
    'name' => 'required', 
    'email' => 'required|email', 
    'password' => 'required',
    'szakId' => 'required',
    'evfolyamId' => 'required'      
  ]);
  if ($validator->fails()) { 
    return response()->json([
      'error'=> true,
      'message' => "Hibás adatok!",            
    ]);
  } 

  $user = new User([
    'name' => $request->name,
    'email' => $request->email,
    'password' => bcrypt($request->password),
    'szakId'=>$request->szakId,
    'evfolyamId'=>$request->evfolyamId
  ]);
  $user->save();
  return response()->json([
    'error'=>false,
    'message' => 'Sikeres regisztráció!',
    'user'=>[
      'id'=>$user->id,
      'name'=>$user->name,
      'email'=>$user->email,
      'szakId'=>$user->szakId,
      'evfolyamId'=>$user->evfolyamId
    ]
  ]);

}


public function login(Request $request){

 $this->validate($request, [

        'email' => 'required|email',
        'password' => 'required',

        ]);

    if (\Auth::attempt([
        'email' => $request->email,
        'password' => $request->password])
    ){
        if(Auth::check() && Auth::user()->is_Admin()) {
          return redirect('/dashboard');
        }
        else{
          auth()->logout();
          return redirect('login')->with('error', 'Nem adminisztrátori fiók.');
        }   

    }
    return redirect('login')->with('error', 'Hibás email vagy jelszó.');  
}

public function androidlogin(Request $request){


  $validator = Validator::make($request->all(), [         
    'email' => 'required|email', 
    'password' => 'required'      
  ]);
  if ($validator->fails()) { 
    return response()->json([
      'error'=> true,
      'message' => "Hibas adatok",            
    ]);
  } 
  $credentials = request(['email', 'password']);
  if(!Auth::attempt($credentials))
    return response()->json([
      'error'=>true,
      'message' => 'Nincs engedélye!'                
    ]);


  $user = $request->user();
  $tokenResult = $user->createToken('Personal Access Token');
  $token = $tokenResult->token;
  if ($request->remember_me)
    $token->expires_at = Carbon::now()->addWeeks(1);
  $token->save();

  return response()->json([
    'error'=>false,
    'message' => 'Sikeres bejelentkezés!',
    'access_token' => $tokenResult->accessToken,
    'token_type' => 'Bearer',  
    'user' => $request->user()
  ]);

}
    /**
     * Logout user (Revoke the token)
     *
     * @return [string] message
     */
    public function logoutandroid(Request $request)
    {

        return response()->json([
            'error' => false,
            'message' => 'Sikeres kijelentkezés.'
        ]);
    }

   
    public function user(Request $request)
    {
      return response()->json($request->user());
    }

    public function logoutweb(Request $request) {
      Auth::logout();
      return redirect('/login');
    }
  }

