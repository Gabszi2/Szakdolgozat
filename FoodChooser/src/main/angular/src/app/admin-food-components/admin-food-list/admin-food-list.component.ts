import {Component, OnInit} from '@angular/core';
import {FoodModel} from "../../models/food-model";
import {AdminFoodService} from "../../services/admin-food.service";
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";

@Component({
  selector: 'app-admin-food-list',
  templateUrl: './admin-food-list.component.html',
  styleUrls: ['./admin-food-list.component.css']
})
export class AdminFoodListComponent implements OnInit {
foodAll!:FoodModel[];
town!:string;
kitchen!:string;
  constructor(private service:AdminFoodService,private route: ActivatedRoute) {
  }

  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.kitchen=<string>this.route.snapshot.paramMap.get('kitchen');
    this.foodAll=await  this.service.getAllFood(this.town,this.kitchen);
  }

async deleteFood(food:FoodModel){
await this.service.deleteFood(this.town,this.kitchen,food);
this.foodAll=await this.service.getAllFood(this.town,this.kitchen)
}
}
