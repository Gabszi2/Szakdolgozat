import {Component, OnInit} from '@angular/core';
import {AdminRecommendationService} from "../../services/admin-recommendation.service";
import {RecommendationModel} from "../../models/recommendation-model";

@Component({
  selector: 'app-admin-approved-rec',
  templateUrl: './admin-approved-rec.component.html',
  styleUrls: ['./admin-approved-rec.component.css']
})
export class AdminApprovedRecComponent implements OnInit {
  approvedRec!: RecommendationModel[];

  constructor(private service: AdminRecommendationService) {
  }

  async ngOnInit() {
    this.approvedRec = await this.service.getAllApprovedRecommendations();
  }

  async delete(id: string) {
    await this.service.deleteRecommendation(id);
    this.approvedRec = await this.service.getAllRecommendations();
  }

}
