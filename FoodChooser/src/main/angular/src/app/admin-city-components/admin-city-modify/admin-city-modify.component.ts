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
  kitchensForm = this.fb.group({
    kitchens: this.fb.array([])
  });
  constructor(private service:AdminCityService, private route: ActivatedRoute,private fb: FormBuilder, private router: Router) { }

  get kitchens(): FormArray {
    return this.kitchensForm.get("kitchens") as FormArray;
  }

  restaurantForm(): FormGroup {
    return this.fb.group({
      kitchen: ['', Validators.required]
    })
  };
  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.city=await this.service.getCity(this.town);

    for (let kitchen in this.city.kitchens) {
      this.addKitchen();
    }
    for (let i = 0; i < this.kitchens.length; i++) {
      this.kitchens.at(i).get("kitchen")?.setValue(this.city.kitchens[i]);

    }
  }
  addKitchen() {
    this.kitchens.push(this.restaurantForm());
  }
   delete(index: number) {
    this.kitchens.removeAt(index);
  }
  async done() {
    let kitchens = [];
    for (let i = 0; i < this.kitchens.length; i++) {
      const element = this.kitchens.at(i).get("kitchen")?.value;
      kitchens.push(element);
    }

    this.city.kitchens = kitchens;

    await this.service.updateCity(this.city);
    await this.router.navigate(['/admin/cities/'])
  }

}
