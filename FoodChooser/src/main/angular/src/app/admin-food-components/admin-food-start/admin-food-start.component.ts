import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
  selector: 'app-admin-food-start',
  templateUrl: './admin-food-start.component.html',
  styleUrls: ['./admin-food-start.component.css']
})
export class AdminFoodStartComponent implements OnInit {
  chooseForm!: FormGroup;
  kitchens: string[] = ['asian', 'turkish'];
  towns: string[] = ['miskolc'];

  constructor(private formBuilder: FormBuilder, private router: Router) {
  }


  ngOnInit() {
    this.chooseForm = this.formBuilder.group({
      town: ['', Validators.required],
      kitchen: ['', Validators.required]
    })
  }

  choice() {
    const town = this.chooseForm.get('town')?.value;
    const kitchen = this.chooseForm.get('kitchen')?.value;
    this.router.navigate(['admin/food-list/' + town + '/' + kitchen]).then(() => {
      window.location.reload()
    })
  }

}
