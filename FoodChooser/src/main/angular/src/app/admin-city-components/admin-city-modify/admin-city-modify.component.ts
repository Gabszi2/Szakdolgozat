import { Component, OnInit } from '@angular/core';
import {AdminCityService} from "../../services/admin-city.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CityModel} from "../../models/city-model";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-admin-city-modify',
  templateUrl: './admin-city-modify.component.html',
  styleUrls: ['./admin-city-modify.component.css']
})
export class AdminCityModifyComponent implements OnInit {
town!:string;
city!:CityModel;
  cuisinesForm = this.fb.group({
    cuisines: this.fb.array([])
  });
  constructor(private service:AdminCityService, private route: ActivatedRoute,private fb: FormBuilder, private router: Router) { }

  get cuisines(): FormArray {
    return this.cuisinesForm.get("cuisines") as FormArray;
  }

  restaurantForm(): FormGroup {
    return this.fb.group({
      cuisine: ['', Validators.required]
    })
  };
  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.city=await this.service.getCity(this.town);

    for (let cuisine in this.city.cuisines) {
      this.addCuisine();
    }
    for (let i = 0; i < this.cuisines.length; i++) {
      this.cuisines.at(i).get("cuisine")?.setValue(this.city.cuisines[i]);

    }
  }
  addCuisine() {
    this.cuisines.push(this.restaurantForm());
  }
   delete(index: number) {
    this.cuisines.removeAt(index);
  }
  async done() {
    let cuisines = [];
    for (let i = 0; i < this.cuisines.length; i++) {
      const element = this.cuisines.at(i).get("cuisine")?.value;
      cuisines.push(element);
    }

    this.city.cuisines = cuisines;

    await this.service.updateCity(this.city);
    await this.router.navigate(['/admin/cities/'])
  }

}
