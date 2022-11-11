import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrescriptionModel } from 'src/app/models/prescription.model';
import { PrescriptionService } from 'src/app/services/prescription.service';

@Component({
  selector: 'app-appointment-get-list',
  templateUrl: './prescription-get-list.component.html',
  styleUrls: ['./prescription-get-list.component.css'],
})
export class PrescriptionGetListComponent implements OnInit {
  isLoading = false;
  prescriptionList: PrescriptionModel[] | undefined;
  prescription: any;

  constructor(
    private prescriptionService: PrescriptionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.isLoading = true;
    this.prescriptionService.getList().subscribe({
      next: (res) => {
        console.log(res);
        this.prescriptionList = res;
        this.isLoading = false;
      },
      error: (error) => {
        this.isLoading = false;
      },
    });
  }

  delete(id: number) {
    let text = 'Do you want to delete the prescription?';
    if (confirm(text) == true) {
      this.prescriptionService.delete(id).subscribe({
        next: (res) => {
          console.log(res);
          if (res == null) {
            alert('Prescription deleted');
            this.getList();
            this.router.navigate(['admin/prescription-get-list']);
          }
        },
        error: (error) => {
          this.isLoading = false;
          alert("Prescription can't delete");
        },
      });
    }
  }

  edit(id: number){
    localStorage.setItem('id',JSON.stringify(id))
  }
}
