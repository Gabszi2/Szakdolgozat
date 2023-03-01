import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AdminFoodService} from "../../services/admin-food.service";
import {CityModel} from "../../models/city-model";


@Component({
  selector: 'app-admin-food-start',
  templateUrl: './admin-food-start.component.html',
  styleUrls: ['./admin-food-start.component.css']
})
export class AdminFoodStartComponent implements OnInit {
  chooseForm!: FormGroup;
  cuisines!: string[];

  cityAll!:CityModel[];

  constructor(private formBuilder: FormBuilder, private router: Router,private service:AdminFoodService) {
  }


  async ngOnInit() {
    this.chooseForm = this.formBuilder.group({
      town: ['', Validators.required],
      cuisine: ['', Validators.required]
    })
    this.cityAll = await this.service.getCities();
  }

  choice() {
    const town = this.cityAll[this.chooseForm.get('town')?.value].name;
    const cuisine = this.chooseForm.get('cuisine')?.value;
    this.router.navigate(['admin/food-list/' + town + '/' + cuisine]).then(() => {
      window.location.reload()
    })
  }
onChange(value:any){
    this.cuisines=this.cityAll[value.target.value].cuisines;
}
}
