import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdminRecommendationService} from "../../services/admin-recommendation.service";
import {RecommendationModel} from "../../models/recommendation-model";

@Component({
  selector: 'app-admin-recommendation-details',
  templateUrl: './admin-recommendation-details.component.html',
  styleUrls: ['./admin-recommendation-details.component.css']
})
export class AdminRecommendationDetailsComponent implements OnInit {
  recommendation!: RecommendationModel

  constructor(private route: ActivatedRoute, private service: AdminRecommendationService, private router: Router) {
  }

  async ngOnInit() {

    const id = <string>this.route.snapshot.paramMap.get('id');
    this.recommendation = await this.service.getRecommendation(id);
  }

  async delete(id: string) {
    await this.service.deleteRecommendation(id);
    await this.router.navigate(['/admin/approved-recommendations']);
  }
}
