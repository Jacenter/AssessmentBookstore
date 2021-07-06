import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-view-book-details',
  templateUrl: './view-book-details.component.html',
  styleUrls: ['./view-book-details.component.css']
})

export class ViewBookDetailsComponent implements OnInit {

  public bookDetails: any;

  constructor(private bookService : BookService, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.getBookDetails(this.route.snapshot.params.id);
  }

  getBookDetails(id:number){
    this.bookService.getBookById(id).subscribe(
      data => {this.bookDetails = data}
    )
  };

}
