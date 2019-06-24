<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class VizsgaResource extends JsonResource
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
            'tantargyId'=> $this->tantargyID,
            'szakId' => $this->szakID,
            'evfolyamId' => $this->evfolyamID,
            'tanarId'=> $this->tanarID,
            'vizsgadatum'=>$this->vizsgadatum         
        ]; 
    }
}
