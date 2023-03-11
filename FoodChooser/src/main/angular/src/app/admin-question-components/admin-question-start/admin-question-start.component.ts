import {Component, OnInit} from '@angular/core';
import {CityModel} from "../../models/city-model";
import {AdminQuestionService} from "../../services/admin-question.service";

@Component({
  selector: 'app-admin-question-start',
  templateUrl: './admin-question-start.component.html',
  styleUrls: ['./admin-question-start.component.css']
})
export class AdminQuestionStartComponent implements OnInit {
  selectedcuisine!: string;
  cuisines!: string[];
  cityAll!: CityModel[];

  constructor(private service: AdminQuestionService) {
  }

  async ngOnInit() {

    this.cityAll = await this.service.getCities();
    this.cuisines = this.cityAll[0].cuisines;

    for (let i = 1; i < this.cityAll.length; i++) {

      for (const citycuisine of this.cityAll[i].cuisines) {
        let notIncuisines = true;
        for (const cuisine of this.cuisines) {
          if (cuisine == citycuisine) {
            notIncuisines = false;
          }
        }
        if (notIncuisines) {
          this.cuisines.push(citycuisine);
        }
      }
    }

  }
}


