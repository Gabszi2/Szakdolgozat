import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

import {Router} from "@angular/router";
import {AdminCityService} from "../../services/admin-city.service";
import {CityModel} from "../../models/city-model";

@Component({
  selector: 'app-admin-city-add',
  templateUrl: './admin-city-add.component.html',
  styleUrls: ['./admin-city-add.component.css']
})
export class AdminCityAddComponent implements OnInit {
  cityForm!: FormGroup;
  constructor(private service: AdminCityService, private router: Router, private formBuilder: FormBuilder) { }

 async ngOnInit(){
    this.cityForm = this.formBuilder.group({
      name: ['', Validators.required]
    })
  }
async cityAdd(){
    const city=<CityModel>{};
    city.name=this.cityForm.get('name')?.value;
    await this.service.addCity(city);
  await this.router.navigate(['/admin/cities'])
}
}
