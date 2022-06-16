import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodAddRestaurantsComponent } from './admin-food-add-restaurants.component';

describe('AdminFoodAddRestaurantsComponent', () => {
  let component: AdminFoodAddRestaurantsComponent;
  let fixture: ComponentFixture<AdminFoodAddRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodAddRestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodAddRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
