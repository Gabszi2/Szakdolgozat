import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {RecommendationModel} from "../../models/recommendation-model";
import {CustomerService} from "../../services/customer.service";


@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent implements OnInit {
  recommendationForm!: FormGroup;
  types:string[]=['food','question','kitchen','restaurant','city'];//TODO ???enum

  constructor(private service:CustomerService,private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.recommendationForm = this.formBuilder.group({
      type: ['', Validators.required],
      kitchen: [''],
      city: [''],
      foodName:[''],
      restaurant: [''],
      message: ['', Validators.required],
  })
  }
async recommendationAdd() {
  const recommendation = <RecommendationModel>{};
  recommendation.type = this.recommendationForm.get('type')?.value
  recommendation.kitchen = this.recommendationForm.get('kitchen')?.value
  recommendation.city = this.recommendationForm.get('city')?.value
  recommendation.foodName=this.recommendationForm.get('foodName')?.value
  recommendation.restaurant = this.recommendationForm.get('restaurant')?.value
  recommendation.message = this.recommendationForm.get('message')?.value
  recommendation.approved=false;
await this.service.createRecommendation(recommendation);
  await this.router.navigate(['/start']);

}
}
