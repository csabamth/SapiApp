<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class SzakResource extends JsonResource
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
            'megnevezes' => $this->megnevezes,
            'rovidites' => $this->rovidites,
            'idotartamEvben' => $this->idotartamEvben,
            'tipus'=> $this->tipus
        ]; 
    }
}
