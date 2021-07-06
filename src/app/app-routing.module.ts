import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksListComponent } from './components/books-list/books-list.component';
import { ViewBookDetailsComponent } from './components/view-book-details/view-book-details.component';

const routes: Routes = [
  {path:'books/view/:id', component: ViewBookDetailsComponent},
  {path:'',component: BooksListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
