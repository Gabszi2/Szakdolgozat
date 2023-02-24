import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

import {Router} from "@angular/router";
import {AdminCityService} from "../../services/admin-city.service";
import {CityModel} from "../../models/city-model";

@Component({
  selector: 'app-admin-city-add',
  templateUrl: './admin-city-add.component.html',
  styleUrls: ['./admin-city-add.component.css']
})
export class AdminCityAddComponent implements OnInit {

  cityForm = this.formBuilder.group({
    name: ['', Validators.required],
    kitchens: this.formBuilder.array([])

  })
  constructor(private service: AdminCityService, private router: Router, private formBuilder: FormBuilder) { }

  get kitchens(): FormArray {
    return this.cityForm.get("kitchens") as FormArray;
  }
  kitchenForm(): FormGroup {
    return this.formBuilder.group({
      kitchen: ['', Validators.required]
    })
  };


  async ngOnInit(){
    this.addKitchen()
  }

  addKitchen() {
    this.kitchens.push(this.kitchenForm());
  }
  delete(index: number) {
    this.kitchens.removeAt(index);
  }
  async cityAdd(){
    const city=<CityModel>{};
    city.name=this.cityForm.get('name')?.value;

    let kitchens = [];
    for (let i = 0; i < this.kitchens.length; i++) {
      const element = this.kitchens.at(i).get("kitchen")?.value;
      kitchens.push(element);
    }
    city.kitchens=kitchens;
    await this.service.addCity(city);
  await this.router.navigate(['/admin/cities'])
}
}
