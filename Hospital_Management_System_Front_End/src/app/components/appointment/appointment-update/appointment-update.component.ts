import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from 'src/app/services/appoitment.service';


@Component({
  selector: 'app-appointment-update',
  templateUrl: './appointment-update.component.html',
  styleUrls: ['./appointment-update.component.css']
})
export class AppointmentUpdateComponent implements OnInit {
  appointment_id!: number;
  isUpdating = false;
  appointment: any;

  constructor(private appointmentService: AppointmentService, private router: Router) { }

  ngOnInit(): void {
    this.appointment_id = JSON.parse(localStorage.getItem('id') || '{}');
    this.appointmentService.getAppointment(this.appointment_id).subscribe({
      next: (res) => {
        this.appointment = res;
        console.log(this.appointment.id);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  onSubmit() {
    console.log(this.appointment);
    this.isUpdating = true;

    this.appointmentService.update(this.appointment_id, this.appointment).subscribe({
      next: (res) => {
        if (res) {
          this.isUpdating = false;
          alert("Appointment Details Updated");
          console.log('response: ' + res);
          this.router.navigate(["admin/appointment-get-list"]);
        }
      },
      error: (err) => {
        this.isUpdating = false;
        console.log('Error: ' + err);
        alert("Appointment Details not updated...!")
      },
    });
  }

}
