import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodModifyRestaurantsComponent } from './admin-food-modify-restaurants.component';

describe('AdminFoodModifyRestaurantsComponent', () => {
  let component: AdminFoodModifyRestaurantsComponent;
  let fixture: ComponentFixture<AdminFoodModifyRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodModifyRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodModifyRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
