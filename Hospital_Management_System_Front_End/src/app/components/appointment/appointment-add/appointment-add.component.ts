import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentModel } from 'src/app/models/appointment.model';
import { AppointmentService } from 'src/app/services/appoitment.service';


@Component({
  selector: 'app-appointment-add',
  templateUrl: './appointment-add.component.html',
  styleUrls: ['./appointment-add.component.css']
})
export class AppointmentAddComponent implements OnInit {

  appointment = new AppointmentModel();

  constructor(private appointmentService: AppointmentService, private router: Router ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.appointmentService.create(this.appointment).subscribe({
      next: (res) => {
        if (res){
          alert("Appointment created successfully");
          this.appointment = new AppointmentModel();
          this.router.navigate(["admin/appointment-add"])
        }
      },
      error: (err) => {
        alert("Something went wrong");
      },
    });
  }
}
