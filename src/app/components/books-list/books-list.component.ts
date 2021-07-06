import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  public books : any;
  public searchName!: string;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.getBooks();
    this.getBooksNameContaining();
  }

  getBooks() {
    this.bookService.getAllBooks().subscribe(
      data => {this.books = data}
    )
  }

  getBooksNameContaining() {
    this.bookService.getAllBooksWithNameContaining(this.searchName).subscribe(
      response => {this.books = response}
    )
  }

}
