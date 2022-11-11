import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentGetListComponent } from './appointment-get-list.component';

describe('AppointmentGetListComponent', () => {
  let component: AppointmentGetListComponent;
  let fixture: ComponentFixture<AppointmentGetListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentGetListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentGetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
