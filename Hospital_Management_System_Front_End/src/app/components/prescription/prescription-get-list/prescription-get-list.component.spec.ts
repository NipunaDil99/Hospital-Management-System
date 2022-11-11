import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptionGetListComponent } from './prescription-get-list.component';

describe('PrescriptionGetListComponent', () => {
  let component: PrescriptionGetListComponent;
  let fixture: ComponentFixture<PrescriptionGetListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrescriptionGetListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrescriptionGetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
