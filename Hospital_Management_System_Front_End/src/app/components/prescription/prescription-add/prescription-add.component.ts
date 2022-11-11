import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrescriptionModel } from 'src/app/models/prescription.model';
import { PrescriptionService } from 'src/app/services/prescription.service';

@Component({
  selector: 'app-prescription-add',
  templateUrl: './prescription-add.component.html',
  styleUrls: ['./prescription-add.component.css']
})
export class PrescriptionAddComponent implements OnInit {
  prescription = new PrescriptionModel();

  constructor(private prescriptionService: PrescriptionService, private router: Router ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.prescriptionService.create(this.prescription).subscribe({
      next: (res) => {
        if (res){
          alert("Prescription created successfully");
          this.prescription = new PrescriptionModel();
          this.router.navigate(["admin/prescription-add"])
        }
      },
      error: (err) => {
        alert("Something went wrong");
      },
    });
  }

}
