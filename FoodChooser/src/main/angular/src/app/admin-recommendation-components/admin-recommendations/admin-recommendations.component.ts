import {Component, OnInit} from '@angular/core';
import {AdminRecommendationService} from "../../services/admin-recommendation.service";
import {RecommendationModel} from "../../models/recommendation-model";

@Component({
  selector: 'app-admin-recommendations',
  templateUrl: './admin-recommendations.component.html',
  styleUrls: ['./admin-recommendations.component.css']
})
export class AdminRecommendationsComponent implements OnInit {
recommendationAll!:RecommendationModel[];
  constructor(private service:AdminRecommendationService) {
  }

  async ngOnInit(){
    this.recommendationAll= await this.service.getAllRecommendations();
  }
async delete(id:number){
    await this.service.deleteRecommendation(id);
    this.recommendationAll= await this.service.getAllRecommendations();
}
async approveChange(id:number){
    await this.service.updateRecommendationApprove(id);
    this.recommendationAll=await this.service.getAllRecommendations()
}
}
