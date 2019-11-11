package com.nlayton.structs;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @author nick.layton
 * @since Nov-2019
 */
class NickLinkedList<E>
        implements List<E> {

    private NickListNode<E> head;
    private NickListNode<E> tail;

    private NickLinkedList(final NickListNode<E> head, final NickListNode<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    NickLinkedList() {
        this(null, null);
    }

    @Override
    public int size() {
        final AtomicInteger size = new AtomicInteger(0);
        forEach(e -> size.incrementAndGet());
        return size.get();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        if (o != null && head != null) {
            for (final E e : this) {
                if (e.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new NickLinkedListIterator<>(this.head);
    }

    @Override
    public Object[] toArray() {
        throwTodo();
        return null;
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        throwTodo();
        return null;
    }

    private static <T> T[] throwTodo() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean add(final E e) {
        checkNotNull(e);
        final AtomicBoolean updated = new AtomicBoolean(false);
        try {
            if (isEmpty()) {
                final NickListNode<E> newNode = new NickListNode<>(e, null, null);
                head = newNode;
                tail = newNode;
                updated.set(true);
            }
            else {
                final NickListNode<E> currentTail = tail;
                tail = new NickListNode<>(e, null, currentTail);
                updated.set(true);
            }
        }
        catch (Exception ignored) {
        }
        return updated.get();
    }

    @Override
    public boolean remove(final Object o) {
        checkNotNull(o);
        NickListNode<E> node = head;
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        final AtomicBoolean added = new AtomicBoolean(false);
        c.forEach(e -> {
            if (add(e)) {
                added.set(true);
            }
        });
        return added.get();

    }

    @Override
    public boolean addAll(final int index, final Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(final int index) {
        return null;
    }

    @Override
    public E set(final int index, final E element) {
        return null;
    }

    @Override
    public void add(final int index, final E element) {

    }

    @Override
    public E remove(final int index) {
        return null;
    }

    @Override
    public int indexOf(final Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(final Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(final int index) {
        return null;
    }

    @Override
    public List<E> subList(final int fromIndex, final int toIndex) {
        return null;
    }

    private static class NickListNode<E> {

        private final E e;
        private NickListNode<E> next;
        private NickListNode<E> previous;

        private NickListNode(final E e, final NickListNode<E> next, final NickListNode<E> previous) {
            this.e = e;
            this.next = next;
            this.previous = previous;
        }
    }

    private static class NickLinkedListIterator<E>
            implements Iterator<E> {

        private NickListNode<E> next;

        private NickLinkedListIterator(final NickListNode<E> next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (next != null) {
                final E nextElement = next.e;
                next = next.next;
                return nextElement;
            }
            return null;
        }

        @Override
        public void remove() {
            throwTodo();
        }

        @Override
        public void forEachRemaining(final Consumer<? super E> action) {
            throwTodo();
        }
    }
}
