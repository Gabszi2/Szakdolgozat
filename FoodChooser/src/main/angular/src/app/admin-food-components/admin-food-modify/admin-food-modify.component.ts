import {Component, OnInit} from '@angular/core';
import {AdminFoodService} from "../../services/admin-food.service";
import {ActivatedRoute} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-admin-food-modify',
  templateUrl: './admin-food-modify.component.html',
  styleUrls: ['./admin-food-modify.component.css']
})
export class AdminFoodModifyComponent implements OnInit {
  foodUpdate!: FoodModel;
  town!: string;
  cuisine!: string;
  foodName!: string

  constructor(private service: AdminFoodService, private route: ActivatedRoute) {

  }

  async ngOnInit() {
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.foodName = <string>this.route.snapshot.paramMap.get('foodName');
    this.foodUpdate = await this.service.getFood(this.town, this.cuisine, this.foodName);
  }

}
