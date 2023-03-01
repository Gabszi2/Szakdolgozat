import {Component, OnInit} from '@angular/core';
import {FoodModel} from "../../models/food-model";
import {AdminFoodService} from "../../services/admin-food.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admin-food-list',
  templateUrl: './admin-food-list.component.html',
  styleUrls: ['./admin-food-list.component.css']
})
export class AdminFoodListComponent implements OnInit {
  foodAll!: FoodModel[];
  town!: string;
  cuisine!: string;

  constructor(private service: AdminFoodService, private route: ActivatedRoute) {
  }

  async ngOnInit() {
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.foodAll = await this.service.getAllFood(this.town, this.cuisine);
  }

  async deleteFood(food: FoodModel) {
    await this.service.deleteFood(this.town, this.cuisine, food);
    this.foodAll = await this.service.getAllFood(this.town, this.cuisine)
  }
}
