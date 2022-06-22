import { Component, OnInit } from '@angular/core';
import {FoodModel} from "../../models/food-model";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";

import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-food-modify-restaurants',
  templateUrl: './admin-food-modify-restaurants.component.html',
  styleUrls: ['./admin-food-modify-restaurants.component.css']
})
export class AdminFoodModifyRestaurantsComponent implements OnInit {
  town!:string;
  kitchen!:string;
  foodName!:string;
  food!:FoodModel;

  restaurantsForm=this.fb.group({
    restaurants:this.fb.array([])
  });

  restaurantForm():FormGroup{
    return this.fb.group({
      restaurant:['',Validators.required]
    })
  };

  constructor(private fb:FormBuilder,private foodService:AdminFoodService,private route: ActivatedRoute,private router:Router) { }

  async ngOnInit() {
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.kitchen = <string>this.route.snapshot.paramMap.get('kitchen');
    this.foodName = <string>this.route.snapshot.paramMap.get('foodName');
    this.food = await this.foodService.getFood(this.town, this.kitchen, this.foodName);

    for (let question in this.food.restaurants) {
      this.addRestaurant();
    }
    for (let i =0; i< this.restaurants.length; i++) {
      this.restaurants.at(i).get("restaurant")?.setValue(this.food.restaurants[i]);

    }

  }

  get restaurants():FormArray{
    return this.restaurantsForm.get("restaurants") as FormArray;
  }
  addRestaurant(){
    this.restaurants.push(this.restaurantForm());
  }
  async done() {
    let restaurants=[];
    for (let i =0; i< this.restaurants.length; i++) {
      const element = this.restaurants.at(i).get("restaurant")?.value;
      restaurants.push(element);
    }

    this.food.restaurants=restaurants;

    await this.foodService.updateFood(this.town,this.kitchen,this.food);
    await this.router.navigate(['/admin/food-list/' + this.town+'/'+this.kitchen])
  }
  async delete(index:number){
    this.restaurants.removeAt(index);
  }
}
