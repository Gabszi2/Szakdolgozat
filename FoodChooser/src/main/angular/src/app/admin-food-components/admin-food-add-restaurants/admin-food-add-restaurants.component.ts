import { Component, OnInit } from '@angular/core';
import {FoodModel} from "../../models/food-model";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-admin-food-add-restaurants',
  templateUrl: './admin-food-add-restaurants.component.html',
  styleUrls: ['./admin-food-add-restaurants.component.css']
})
export class AdminFoodAddRestaurantsComponent implements OnInit {
  town!:string;
  kitchen!:string;
  foodName!:string;
  food!:FoodModel;
  restaurants:string[]=[];
  restaurantForm=this.formBuilder.group({
    name:['',Validators.required]
  });
  constructor(private foodService:AdminFoodService,private route: ActivatedRoute,private router:Router,private formBuilder:FormBuilder) { }

  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.kitchen=<string>this.route.snapshot.paramMap.get('kitchen');
    this.foodName=<string>this.route.snapshot.paramMap.get('foodName');
    this.food=await this.foodService.getFood(this.town, this.kitchen, this.foodName);

  }

  async restaurantAdd() {
    const restaurant = this.restaurantForm.get('name')?.value;

      this.restaurants.push(restaurant);


  }
  async done() {

    this.food.restaurants=this.restaurants;
    await this.foodService.updateFood(this.town, this.kitchen, this.food);
    await this.router.navigate(['/admin/food-list/' + this.town+'/'+this.kitchen]);
  }
}
