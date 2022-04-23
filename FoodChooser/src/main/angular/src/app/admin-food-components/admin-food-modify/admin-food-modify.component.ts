import {Component, OnInit} from '@angular/core';
import {AdminFoodService} from "../../services/admin-food.service";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-admin-food-modify',
  templateUrl: './admin-food-modify.component.html',
  styleUrls: ['./admin-food-modify.component.css']
})
export class AdminFoodModifyComponent implements OnInit {
foodUpdate=<FoodModel>{};
routeState!:any;
  constructor(private service:AdminFoodService,private formBuilder:FormBuilder,private router:Router,private route:ActivatedRoute) {

  }

  ngOnInit(): void {


  }

}
