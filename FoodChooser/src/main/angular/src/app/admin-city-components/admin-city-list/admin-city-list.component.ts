import {Component, OnInit} from '@angular/core';
import {AdminCityService} from "../../services/admin-city.service";
import {CityModel} from "../../models/city-model";

@Component({
  selector: 'app-admin-city-list',
  templateUrl: './admin-city-list.component.html',
  styleUrls: ['./admin-city-list.component.css']
})
export class AdminCityListComponent implements OnInit {
  cityAll!: CityModel[];

  constructor(private service: AdminCityService) {
  }

  async ngOnInit() {
    this.cityAll = await this.service.getCities();
  }

  async deleteCity(name: string) {
    await this.service.deleteCity(name);
    this.cityAll = await this.service.getCities();
  }

}
