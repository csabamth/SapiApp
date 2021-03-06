<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class EventResource extends JsonResource
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
            'cim' => $this->cim,
            'leiras' => $this->leiras,
            'img_url' => $this->img_url,
            'esemeny_datum' => $this->esemeny_datum,
        ]; 
    }
}
