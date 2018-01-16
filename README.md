# TextWithImage
Android Text with image at the start, support vector drawable. I will support forth direction in future too.

# Introduction

With this library, you can easily setup your view by specific dimension of your image. 

<h4>All custom properties</h4>

```java
app:twi_image="@drawable/ic_backup_black_24dp"
app:twi_image_tint="@color/colorPrimary"
app:twi_image_width="30dp"
app:twi_image_height="30dp"
app:twi_text="Text With Starting Image"
app:twi_text_color="@color/colorAccent"
app:twi_text_padding_start="8dp"
app:twi_text_size_sp="30"/>
```

<h4>Result</h4>

![Result](https://github.com/vuongxuanhong/TextWithImage/raw/master/screenshot/textwithimage.png) <!-- .element height="50%" width="50%" -->


# Installation

Gradle Dependency

```gradle
compile 'studio.eight.textwithimage:textwithimage:1.0.0'
```

# Sample

```java
<studio.eight.textwithimage.TextWithImage
    android:id="@+id/view_button2"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginBottom="8dp"
    android:layout_marginEnd="8dp"
    android:layout_marginStart="8dp"
    android:layout_marginTop="8dp"
    android:gravity="center_vertical"
    android:paddingStart="8dp"
    android:paddingEnd="8dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:twi_image="@drawable/ic_backup_black_24dp"
    app:twi_image_tint="@color/colorPrimary"
    app:twi_image_width="30dp"
    app:twi_image_height="30dp"
    app:twi_text="Text With Starting Image"
    app:twi_text_color="@color/colorAccent"
    app:twi_text_padding_start="8dp"
    app:twi_text_size_sp="30"/>
```

Thanks and have fun
