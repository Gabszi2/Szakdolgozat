import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodModifyComponent } from './admin-food-modify.component';

describe('AdminFoodModifyComponent', () => {
  let component: AdminFoodModifyComponent;
  let fixture: ComponentFixture<AdminFoodModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodModifyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
