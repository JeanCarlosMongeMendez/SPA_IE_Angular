import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CourseComponent } from './course/course.component';
import { Observable } from 'rxjs';
import { FormCourseComponent } from './form-course/form-course.component';

const appRoutes: Routes = [
  {
    path: 'form-course',
    component: FormCourseComponent,
    data: { title: 'Course Add' }
  },
];

@NgModule({
  declarations: [
    AppComponent,
    CourseComponent,
    FormCourseComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CourseComponent,
    Observable,
    FormCourseComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
