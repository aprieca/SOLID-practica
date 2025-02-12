package com.kreitek.files;

import com.kreitek.files.interfaces.Directory;
import com.kreitek.files.interfaces.FileSystemItem;

public abstract class FileSystemItemBase implements FileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected FileSystemItem parent;

    protected FileSystemItemBase(FileSystemItem parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.name = name;
    }

    @Override
    public FileSystemItem getParent() {
        return parent;
    }

    @Override
    public void setParent(FileSystemItem item) {
        if (item != null && !(item instanceof DirectoryImpl)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        if (this.parent != item) {
            if (this.parent != null) ((Directory)parent).removeFile(this);
            this.parent = item;
            if (item != null) ((Directory)item).addFile(this);
        }
    }
    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }

    @Override
    public abstract int getSize();
}
