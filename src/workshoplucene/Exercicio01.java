package workshoplucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.MultiTerms;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.util.BytesRef;

import java.io.IOException;
import java.util.List;

public class Exercicio01 {
  public static void main(String[] args) throws IOException, ParseException {
    // Cria o analizador
    StandardAnalyzer analyzer = new StandardAnalyzer();

    // Diretório virtual para o índice
    Directory indexDirectory = new RAMDirectory();

    // Cria configuração do IndexWriter
    IndexWriterConfig config = new IndexWriterConfig(analyzer);

    // Cria o arquivo com tamanho ilimitado.
    IndexWriter w = new IndexWriter(indexDirectory, config);

    // Adiciona 4 documentos.
    addDoc(w, "Estudando Lucene"); 
    addDoc(w, "Lucene é vida");
    addDoc(w, "Estudo na UFBA");
    addDoc(w, "Moro em Salvador");

    // Fecha o arquivo.
    w.close();
  }
  
    private static void addDoc(IndexWriter w, String text) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", text, Field.Store.YES));
        w.addDocument(doc);
    }
}