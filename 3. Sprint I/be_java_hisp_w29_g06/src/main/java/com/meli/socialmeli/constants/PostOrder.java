package com.meli.socialmeli.constants;

import com.meli.socialmeli.entity.Post;

import java.util.Comparator;

public enum PostOrder {
    ASCENDING(1) {
        @Override
        public Comparator<Post> getComparator() {
            return Comparator.comparing(Post::getDate);
        }

        @Override
        public int getValueFromOrder() {
            return 1;
        }
    },
    DESCENDING(2) {
        @Override
        public Comparator<Post> getComparator() {
            return Comparator.comparing(Post::getDate).reversed();
        }

        @Override
        public int getValueFromOrder() {
            return 2;
        }
    };

    private final int value;

    PostOrder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract Comparator<Post> getComparator();

    public abstract int getValueFromOrder();
}