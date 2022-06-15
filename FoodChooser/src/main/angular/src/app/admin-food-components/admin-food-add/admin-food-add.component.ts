import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-admin-food-add',
  templateUrl: './admin-food-add.component.html',
  styleUrls: ['./admin-food-add.component.css']
})
export class AdminFoodAddComponent implements OnInit {
  town!:string;
  kitchen!:string;
  foodForm!:FormGroup;

  constructor(private foodService:AdminFoodService,private route: ActivatedRoute,private formBuilder:FormBuilder,private router:Router) {
  }

  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.kitchen=<string>this.route.snapshot.paramMap.get('kitchen');
    this.foodForm=this.formBuilder.group({
      name:['',Validators.required]
    })
  }

async foodAdd() {
  const name = this.foodForm.get('name')?.value;
  const food=<FoodModel>{};
  food.foodName=name;
  await this.foodService.addFood(this.town, this.kitchen, food);
  await this.router.navigate(['/admin/food-add-answers/' + this.town+'/'+this.kitchen+'/'+name])
}
}
