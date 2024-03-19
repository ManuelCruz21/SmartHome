package SmartHomeDDD.ValueObject;

import SmartHomeDDD.ddd.ValueObject;

public class ZipCode implements ValueObject {

    private int _zipCodePrefix;
    private int _zipCodeSuffix;

    /**
     * Constructor for ZipCode class
     * @param zipCodePrefix is the zip code prefix of ZipCode
     * @param zipCodeSuffix is the zip code suffix of ZipCode
     */
    public ZipCode(int zipCodePrefix, int zipCodeSuffix) {
        zipCodePrefixValidation(zipCodePrefix);
        zipCodeSuffixValidation(zipCodeSuffix);
    }

    /**
     * Validates the zip code prefix
     * @param postCodePrefix is the zip code prefix of ZipCode
     */
    private void zipCodePrefixValidation(int postCodePrefix){
        if (postCodePrefix < 1000 || postCodePrefix > 9999 ) {
            throw new IllegalArgumentException("Invalid zip code prefix");
        } else {
            this._zipCodePrefix = postCodePrefix;
        }
    }

    /**
     * Validates the zip code suffix
     * @param zipCodeSuffix is the zip code suffix of ZipCode
     */
    private void zipCodeSuffixValidation(int zipCodeSuffix){
        if (zipCodeSuffix < 100 || zipCodeSuffix > 999) {
            throw new IllegalArgumentException("Invalid zip code suffix");
        } else {
            this._zipCodeSuffix = zipCodeSuffix;
        }
    }

    /**
     * Equals method for ZipCode.
     *
     * @param object Object.
     * @return boolean.
     */
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object instanceof ZipCode) {
            ZipCode zipCode = (ZipCode) object;
            if (this._zipCodePrefix == zipCode._zipCodePrefix && this._zipCodeSuffix == zipCode._zipCodeSuffix)
                return true;
        }
        return false;
    }

    /**
     * Getter for zip code prefix.
     * @return _zipCodePrefix.
     */
    public int getZipCodePrefix() {
        return _zipCodePrefix;
    }

    /**
     * Getter for zip code suffix.
     * @return _zipCodeSuffix.
     */
    public int getZipCodeSuffix() {
        return _zipCodeSuffix;
    }

    /**
     * Address object to string
     * @return String
     */
    @Override
    public String toString() {
        return _zipCodePrefix + "-" + _zipCodeSuffix;
    }


}
