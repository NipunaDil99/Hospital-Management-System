import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentModel } from 'src/app/models/appointment.model';
import { AppointmentService } from 'src/app/services/appoitment.service';


@Component({
  selector: 'app-appointment-get-list',
  templateUrl: './appointment-get-list.component.html',
  styleUrls: ['./appointment-get-list.component.css'],
})
export class AppointmentGetListComponent implements OnInit {
  isLoading = false;
  appointmentList: AppointmentModel[] | undefined;
  appointment: any;

  constructor(
    private appointmentService: AppointmentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.isLoading = true;
    this.appointmentService.getList().subscribe({
      next: (res) => {
        console.log(res);
        this.appointmentList = res;
        this.isLoading = false;
      },
      error: (error) => {
        this.isLoading = false;
      },
    });
  }

  delete(id: any) {
    let text = 'Do you want to delete the appoinment?';
    if (confirm(text) == true) {
      this.appointmentService.delete(id).subscribe({
        next: (res) => {
          console.log(res);
          if (res == null) {
            alert('Appoinment deleted');
            this.getList();
            this.router.navigate(['admin/appointment-get-list']);
          }
        },
        error: (error) => {
          this.isLoading = false;
          alert("Appoinment can't delete");
        },
      });
    }
  }

  edit(id: number){
    localStorage.setItem('id',JSON.stringify(id))
  }
}
