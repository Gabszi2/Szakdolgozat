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
    cuisines: this.formBuilder.array([])

  })
  constructor(private service: AdminCityService, private router: Router, private formBuilder: FormBuilder) { }

  get cuisines(): FormArray {
    return this.cityForm.get("cuisines") as FormArray;
  }
  cuisineForm(): FormGroup {
    return this.formBuilder.group({
      cuisine: ['', Validators.required]
    })
  };


  async ngOnInit(){
    this.addCuisine()
  }

  addCuisine() {
    this.cuisines.push(this.cuisineForm());
  }
  delete(index: number) {
    this.cuisines.removeAt(index);
  }
  async cityAdd(){
    const city=<CityModel>{};
    city.name=this.cityForm.get('name')?.value;

    let cuisines = [];
    for (let i = 0; i < this.cuisines.length; i++) {
      const element = this.cuisines.at(i).get("cuisine")?.value;
      cuisines.push(element);
    }
    city.cuisines=cuisines;
    await this.service.addCity(city);
  await this.router.navigate(['/admin/cities'])
}
}
