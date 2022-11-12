import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrescriptionService } from 'src/app/services/prescription.service';

@Component({
  selector: 'app-prescription-update',
  templateUrl: './prescription-update.component.html',
  styleUrls: ['./prescription-update.component.css']
})
export class PrescriptionUpdateComponent implements OnInit {
  prescription_id!: number;
  isUpdating = false;
  prescription: any;

  constructor(private prescriptionService: PrescriptionService, private router: Router) { }

  ngOnInit(): void {
    this.prescription_id = JSON.parse(localStorage.getItem('id') || '{}');
    this.prescriptionService.getPrescription(this.prescription_id).subscribe({
      next: (res) => {
        this.prescription = res;
        console.log(this.prescription.id);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  onSubmit() {
    console.log(this.prescription);
    this.isUpdating = true;

    this.prescriptionService.update(this.prescription_id, this.prescription).subscribe({
      next: (res) => {
        if (res) {
          this.isUpdating = false;
          alert("Prescription Details Updated");
          console.log('response: ' + res);
          this.router.navigate(["admin/prescription-get-list"]);
        }
      },
      error: (err) => {
        this.isUpdating = false;
        console.log('Error: ' + err);
        alert("Prescription Details not updated...!")
      },
    });
  }

}
