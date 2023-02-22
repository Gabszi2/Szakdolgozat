import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCityAddComponent } from './admin-city-add.component';

describe('AdminCityAddComponent', () => {
  let component: AdminCityAddComponent;
  let fixture: ComponentFixture<AdminCityAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCityAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCityAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
