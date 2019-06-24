<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class MenuResource extends JsonResource
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
            'hetfo_leves'=> $this->hetfo_leves,
            'hetfo_fofogas' => $this->hetfo_fofogas,
              'kedd_leves'=> $this->kedd_leves,
            'kedd_fofogas' => $this->kedd_fofogas,
              'szerda_leves'=> $this->szerda_leves,
            'szerda_fofogas' => $this->szerda_fofogas,
              'csutortok_leves'=> $this->csutortok_leves,
            'csutortok_fofogas' => $this->csutortok_fofogas,
              'pentek_leves'=> $this->pentek_leves,
            'pentek_fofogas' => $this->pentek_fofogas,
            'mettol' => $this->mettol,
            'meddig'=> $this->meddig
        ]; 
    }
}
