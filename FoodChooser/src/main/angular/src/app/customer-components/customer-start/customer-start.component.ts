import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";
import {CityModel} from "../../models/city-model";

@Component({
  selector: 'app-customer-components-start',
  templateUrl: './customer-start.component.html',
  styleUrls: ['./customer-start.component.css']
})
export class CustomerStartComponent implements OnInit {
  chooseForm!: FormGroup;
  cuisines!: string[];
  cityAll!: CityModel[]

  constructor(private service: CustomerService, private formBuilder: FormBuilder, private router: Router) {
  }


  async ngOnInit() {
    this.chooseForm = this.formBuilder.group({
      town: ['', Validators.required],
      cuisine: ['', Validators.required]
    })
    this.cityAll = await this.service.getCities()
  }

  choice() {
    const town = this.cityAll[this.chooseForm.get('town')?.value].name;
    const cuisine = this.chooseForm.get('cuisine')?.value;
    this.router.navigate(['question-form/' + town + '/' + cuisine]).then(() => {
      window.location.reload()
    })
  }

  onChange(value: any) {
    this.cuisines = this.cityAll[value.target.value].cuisines;
  }
}
