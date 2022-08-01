import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-customer-results',
  templateUrl: './customer-results.component.html',
  styleUrls: ['./customer-results.component.css']
})
export class CustomerResultsComponent implements OnInit {
  town!:string;
  kitchen!:string;
  answers!:boolean[];
result=<FoodModel>{};

  constructor(private fb:FormBuilder,private service:CustomerService,private route: ActivatedRoute,private router:Router) { }

  async ngOnInit(){
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.kitchen = <string>this.route.snapshot.paramMap.get('kitchen');
    this.answers=JSON.parse(<string>this.route.snapshot.paramMap.get('answers'));
    this.result=await this.service.getResult(this.answers,this.town,this.kitchen)
  }

}
