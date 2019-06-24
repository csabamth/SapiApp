<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class TanarResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array
     */
    public function toArray($request)
    {
          return [
            'id'=> $this->id,
            'vezeteknev' => $this->vezeteknev,
            'keresztnev' => $this->keresztnev,
            'funkcio' => $this->funkcio
        ]; 
    }
}
