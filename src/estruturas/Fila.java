package estruturas; // Definindo o pacote

import java.util.LinkedList; // Importa a classe LinkedList para a implementação da fila

public class Fila<T> {
    private LinkedList<T> elementos; // Lista que armazenará os elementos da fila

    // Construtor da fila
    public Fila() {
        this.elementos = new LinkedList<>();
    }

    // Método para adicionar um elemento à fila
    public void enqueue(T elemento) {
        elementos.addLast(elemento); // Adiciona no final da lista
    }

    // Método para remover e retornar o elemento da frente da fila
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return elementos.removeFirst(); // Remove e retorna o primeiro elemento
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return elementos.isEmpty(); // Retorna true se a lista estiver vazia
    }

    // Método para retornar o tamanho da fila
    public int size() {
        return elementos.size(); // Retorna o número de elementos na fila
    }

    // Método para visualizar o primeiro elemento da fila sem removê-lo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return elementos.getFirst(); // Retorna o primeiro elemento sem remover
    }
}
