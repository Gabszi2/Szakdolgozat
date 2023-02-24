import {Component, OnInit} from '@angular/core';
import {CityModel} from "../../models/city-model";
import {AdminQuestionService} from "../../services/admin-question.service";

@Component({
  selector: 'app-admin-question-start',
  templateUrl: './admin-question-start.component.html',
  styleUrls: ['./admin-question-start.component.css']
})
export class AdminQuestionStartComponent implements OnInit {
  selectedKitchen!: string;
  kitchens!: string[];
  cityAll!:CityModel[];

  constructor(private service:AdminQuestionService) {
  }

  async ngOnInit(){

    this.cityAll= await this.service.getCities();
    this.kitchens=this.cityAll[0].kitchens;

    for (let i=1;i<this.cityAll.length;i++){

      for (const cityKitchen of this.cityAll[i].kitchens) {
        let notInKitchens = true;
        for (const kitchen of this.kitchens) {
          if (kitchen == cityKitchen) {
            notInKitchens = false;
          }
        }
        if (notInKitchens) {
          this.kitchens.push(cityKitchen);
        }
      }
    }

    }
  }


