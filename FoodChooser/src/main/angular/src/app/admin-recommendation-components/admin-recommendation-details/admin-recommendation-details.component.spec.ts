import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRecommendationDetailsComponent } from './admin-recommendation-details.component';

describe('AdminRecommendationDetailsComponent', () => {
  let component: AdminRecommendationDetailsComponent;
  let fixture: ComponentFixture<AdminRecommendationDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminRecommendationDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRecommendationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
