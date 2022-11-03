import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorModel } from 'src/app/models/doctor.model';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-add',
  templateUrl: './doctor-add.component.html',
  styleUrls: ['./doctor-add.component.css']
})
export class DoctorAddComponent implements OnInit {
  doctor = new DoctorModel();

  constructor(private doctorService: DoctorService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.doctorService.create(this.doctor).subscribe({
      next: (res) => {
        if(res){
          alert("Doctor create sucess")
          this.doctor = new DoctorModel();
          this.router.navigate(["admin/doctor-add"]);
        }

      },
      error: (err) => {
        alert("Something went wrong");
      },
    });

  }

}
