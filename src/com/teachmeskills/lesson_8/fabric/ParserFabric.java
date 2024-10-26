package com.teachmeskills.lesson_8.fabric;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.document_parser.impl.DocxDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.TxtDocumentParser;

public class ParserFabric {
    // TODO избавиться от return null и сделать возврат docx парсера
    // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись
    public static IParser createParser(String fileName){
        switch (fileName.substring(fileName.lastIndexOf('.'))) { //загуглила как "забрать" только расширение
            case ".docx":
                return new DocxDocumentParser();
            case ".pdf":
                return new PdfDocumentParser();
                case ".txt":
            default:
                return new TxtDocumentParser();
        }
    }
}
